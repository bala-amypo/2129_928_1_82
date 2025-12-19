package com.example.demo.Controller;

import com.example.demo.Entity.UserAccount;
import com.example.demo.Service.UserAccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAccountController {

    @Inject
    private UserAccountService userAccountService;

    // Create a new user
    @POST
    public Response createUser(UserAccount userAccount) {
        UserAccount createdUser = userAccountService.createUser(userAccount);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    // Get all users
    @GET
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    // Get user by ID
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        Optional<UserAccount> user = userAccountService.getUserById(id);
        return user.map(Response::ok)
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    // Update user
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserAccount userAccount) {
        UserAccount updatedUser = userAccountService.updateUser(id, userAccount);
        return Response.ok(updatedUser).build();
    }

    // Delete user
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userAccountService.deleteUser(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
