/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.semantic;

import com.mongodb.MongoClientURI;
import edu.illinois.ncsa.incore.common.auth.Authorizer;
import edu.illinois.ncsa.incore.common.auth.IAuthorizer;
import edu.illinois.ncsa.incore.common.config.Config;
import edu.illinois.ncsa.incore.common.dao.ISpaceRepository;
import edu.illinois.ncsa.incore.common.dao.MongoSpaceDBRepository;
import edu.illinois.ncsa.incore.service.semantic.daos.IDatasetTypeDAO;
import edu.illinois.ncsa.incore.service.semantic.daos.MongoDBDatasetTypeDAO;
import org.apache.log4j.Logger;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
    private static final Logger log = Logger.getLogger(Application.class);

    public Application() {
        String semanticsMongodbUri = "mongodb://localhost:27017/semanticsdb";
        String mongodbSpaceUri = "mongodb://localhost:27017/spacedb";

        String semanticsMongodbUriProp = Config.getConfigProperties().getProperty("semantics.mongodbURI");
        if (semanticsMongodbUriProp != null && !semanticsMongodbUriProp.isEmpty()) {
            semanticsMongodbUri = semanticsMongodbUriProp;
        }

        // use same instance of mongo client
        IDatasetTypeDAO conceptDAO = new MongoDBDatasetTypeDAO(new MongoClientURI(semanticsMongodbUri));
        conceptDAO.initialize();

        String mongodbSpaceUriProp = Config.getConfigProperties().getProperty("space.mongodbURI");
        if(mongodbSpaceUriProp != null && !mongodbSpaceUriProp.isEmpty()) {
            mongodbSpaceUri = mongodbSpaceUriProp;
        }

        ISpaceRepository mongoSpaceRepository = new MongoSpaceDBRepository(new MongoClientURI(mongodbSpaceUri));
        mongoSpaceRepository.initialize();

        IAuthorizer authorizer = Authorizer.getInstance();

        super.register(new AbstractBinder() {
            @Override
            protected void configure() {
                super.bind(conceptDAO).to(IDatasetTypeDAO.class);
                super.bind(mongoSpaceRepository).to(ISpaceRepository.class);
                super.bind(authorizer).to(IAuthorizer.class);
            }
        });

    }
}
