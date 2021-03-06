package edu.illinois.ncsa.incore.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.illinois.ncsa.incore.common.exceptions.IncoreHTTPException;
import edu.illinois.ncsa.incore.common.models.UserInfo;

import javax.ws.rs.core.Response;

public class UserInfoUtils {

    /***
     * This method receives a user info json, validates it, maps it, and extracts the username from it. If it fails to map
     * it, then it throws an IncoreHttpException with a detailed message explaining the issue.
     * @param userInfo json representation of user info
     * @return username string if user info json is valid, throws IncoreHttpException otherwise.
     */
    public static String getUsername(String userInfo) {
        if (userInfo == null || !JsonUtils.isJSONValid(userInfo)) {
            throw new IncoreHTTPException(Response.Status.BAD_REQUEST, "The user-info json provided is invalid.");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserInfo user = objectMapper.readValue(userInfo, UserInfo.class);
            if (user.getPreferredUsername() == null) {
                throw new IncoreHTTPException(Response.Status.BAD_REQUEST, "User-info is missing the preferred-username field.");
            } else {
                return user.getPreferredUsername();
            }
        } catch (Exception e) {
            throw new IncoreHTTPException(Response.Status.BAD_REQUEST, "Could not map provided user-info.");
        }
    }

}
