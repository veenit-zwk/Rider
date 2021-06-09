package com.zworthkey.rider2.utils;


import com.zworthkey.rider2.utils.pojoClasses.PojoExample;
import com.zworthkey.rider2.utils.pojoClasses.PojoUserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestroAPI {


    @FormUrlEncoded
    @POST("/client/source/wp-json/custom-plugin/delivery")
    Call<ArrayList<PojoExample>> getDeliveryData(@Field("username") String riderUsername, @Field("password") String password);

    @FormUrlEncoded
    @POST("/client/source/wp-json/custom-plugin/login")
    Call<PojoUserResponse> getUserLoginResponse(@Field("username") String riderUsername,  @Field("password")  String riderUserPassword);

    @FormUrlEncoded
    @POST("/client/source/wp-json/custom-plugin/analytics")
    Call<ArrayList<PojoExample>> getAnalyticsData(@Field("username") String riderUsername,  @Field("password")  String riderUserPassword);

   /* @FormUrlEncoded
    @POST("api/register")
    Call<LoginResponse> registerUser(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("password_confirmation") String password_confirmation, @Field("image") Image image);

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> loginUser(@Field("email") String email, @Field("password") String password);

    @GET("api/users")
    Call<UsersResponse> getAllUsers();


    @GET("api/meals")
    Call<MealsResponse> getAllMeals();

    @GET("api/rooms")
    Call<RoomsResponse> getAllRooms();

    @GET("api/room_categories")
    Call<RoomCategoriesResponse> getAllRoomCategories();

    @GET("api/permissions")
    Call<PermissionsResponse> getAllPermissions();

    @GET("api/roles")
    Call<RolesResponse> getAllRoles();

    @GET("api/customers")
    Call<CustomersResponse> getAllCustomers();

    @GET("api/countries")
    Call<CountryResponse> getAllCountries();

    @GET("api/bookings")
    Call<BookingsResponse> getAllBookings();

    @GET("api/categories")
    Call<MealsCategoryResponse> getAllMealCategories();

*//*
These Uris will be supported as soon as possible.
    @GET("api/shippings")
    Call<JsonResponse> getAllShippings();


    @GET("api/Orders")
    Call<JsonResponse> getAllOrders();


    @GET("api/payments")
    Call<JsonResponse> getAllPayments();
*//*








*/

}
