/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Yong Wook Kim (NCSA) - initial API and implementation
 * Gowtham Naraharisetty
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.data.controllers;

import edu.illinois.ncsa.incore.service.data.models.Dataset;
import mocks.MockApplication;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.TestProperties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatasetControllerTest extends CustomJerseyTest{

    public DatasetControllerTest() { super();}

    @Override
    public ResourceConfig configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");

        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        MockApplication application  = new MockApplication(DatasetController.class);

        return application;
    }

    @Test
    public void testRequestWithBadUserInfoJson() {
        try {
            String output = target("/datasets").request().header("x-auth-userinfo", "{\"username\": \"test\"}").accept(MediaType.APPLICATION_JSON).get(String.class);
        } catch (BadRequestException e){
            int expectedStatusCode = 400;
            int actualStatusCode = e.getResponse().getStatus();

            assertEquals(expectedStatusCode, actualStatusCode);
        }
    }

    @Test
    public void testListDataset() {
        String output = target("/datasets").request().header("x-auth-userinfo", "{\"preferred_username\": \"test\"}").accept(MediaType.APPLICATION_JSON).get(String.class);
        JSONArray parsedObject = new JSONArray(output);

        assertEquals(5, parsedObject.length());
        JSONObject firstObject = new JSONObject(parsedObject.get(0).toString());

        assertNotNull(firstObject.get("id").toString());
        assertNotNull(firstObject.get("dataType").toString());
        assertNotEquals(0, firstObject.get("fileDescriptors").toString().length());

    }

    @Test
    public void testDatasetById() {
        String id = "5a207b29beefa40740e87c93";
        Dataset dataset = target("/datasets/" + id).request().header("x-auth-userinfo", "{\"preferred_username\": \"test\"}").accept(MediaType.APPLICATION_JSON).get(Dataset.class);

        assertNotNull(dataset.getId());
    }

    @Test
    public void testIngestDataset() throws IOException {
        URL jsonURL = this.getClass().getClassLoader().getResource("json/datasetPost.json");
        InputStream inputStream = jsonURL.openStream();
        String jsontext = IOUtils.toString(inputStream);
        final FormDataMultiPart multiPartEntity = new FormDataMultiPart().field("dataset", jsontext);
        Response response = target("/datasets").register(MultiPartWriter.class).request().header("x-auth-userinfo", "{\"preferred_username\": \"test\"}").post(Entity.entity(multiPartEntity, multiPartEntity.getMediaType()));
        Dataset output = response.readEntity(Dataset.class);

        assertNotNull(output.getId());
        assertNotNull(output.getTitle());
    }

    @Test
    public void testGetDatasetFiles() throws IOException {
        String id = "5ac4ef37f9ebf2057a08f566";

        String output = target("/datasets/" + id + "/files").request().header("x-auth-userinfo", "{\"preferred_username\": \"test\"}").accept(MediaType.APPLICATION_JSON).get(String.class);
        JSONArray parsedObject = new JSONArray(output);

        assertEquals(1, parsedObject.length());
        JSONObject firstObject = new JSONObject(parsedObject.get(0).toString());
        assertNotNull(firstObject.get("id").toString());
    }

    @Test void getGetDatasetFileById() throws IOException{
        String dsId = "5ac4ef37f9ebf2057a08f566";
        String fileId = "5a393841c7d30d044d9b66f4";

        String output = target("/datasets/" + dsId+ "/files/"+fileId).request().header("x-auth-userinfo", "{\"preferred_username\": \"test\"}").accept(MediaType.APPLICATION_JSON).get(String.class);
        JSONObject parsedObject = new JSONObject(output);

        //assertEquals(1, parsedObject.length());
        assertNotNull(parsedObject.get("id").toString());
    }




}
