package com.example.multiviewholder


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ApiData(
    @SerializedName("multiBrand")
    @Expose
    var multiBrand: Boolean?,
    @SerializedName("page")
    @Expose
    var page: Int?,
    @SerializedName("pageSize")
    @Expose
    var pageSize: Int?,
    @SerializedName("stores")
    @Expose
    var stores: List<Store?>?,
    @SerializedName("timeStamp")
    @Expose
    var timeStamp: Long?,
    @SerializedName("totalCount")
    @Expose
    var totalCount: Int?
) {
    data class Store(
        @SerializedName("amenities")
        @Expose
        var amenities: List<Amenity?>?,
        @SerializedName("brandImageUrl")
        @Expose
        var brandImageUrl: String?,
        @SerializedName("brandName")
        @Expose
        var brandName: String?,
        @SerializedName("brandOid")
        @Expose
        var brandOid: Int?,
        @SerializedName("brandType")
        @Expose
        var brandType: String?,
        @SerializedName("businessHours")
        @Expose
        var businessHours: List<BusinessHour?>?,
        @SerializedName("calendarType")
        @Expose
        var calendarType: Any?,
        @SerializedName("cityName")
        @Expose
        var cityName: Any?,
        @SerializedName("contactPerson")
        @Expose
        var contactPerson: ContactPerson?,
        @SerializedName("countryName")
        @Expose
        var countryName: Any?,
        @SerializedName("deliveryHours")
        @Expose
        var deliveryHours: List<DeliveryHour?>?,
        @SerializedName("dynamicLink")
        @Expose
        var dynamicLink: String?,
        @SerializedName("festivalHours")
        @Expose
        var festivalHours: Any?,
        @SerializedName("holiday")
        @Expose
        var holiday: Any?,
        @SerializedName("latitude")
        @Expose
        var latitude: String?,
        @SerializedName("longitude")
        @Expose
        var longitude: String?,
        @SerializedName("mallName")
        @Expose
        var mallName: Any?,
        @SerializedName("menuUrl")
        @Expose
        var menuUrl: Any?,
        @SerializedName("radius")
        @Expose
        var radius: Any?,
        @SerializedName("status")
        @Expose
        var status: String?,
        @SerializedName("storeAddress")
        @Expose
        var storeAddress: String?,
        @SerializedName("storeCode")
        @Expose
        var storeCode: String?,
        @SerializedName("storeImagePath")
        @Expose
        var storeImagePath: String?,
        @SerializedName("storeName")
        @Expose
        var storeName: String?,
        @SerializedName("storeOid")
        @Expose
        var storeOid: Int?,
        @SerializedName("storeService")
        @Expose
        var storeService: StoreService?
    ) {
        data class Amenity(
            @SerializedName("amenityOid")
            @Expose
            var amenityOid: Int?,
            @SerializedName("amenityTitle")
            @Expose
            var amenityTitle: String?,
            @SerializedName("direction")
            @Expose
            var direction: Any?,
            @SerializedName("imagePath")
            @Expose
            var imagePath: String?
        )

        data class BusinessHour(
            @SerializedName("day")
            @Expose
            var day: String?,
            @SerializedName("isAvalilable247")
            @Expose
            var isAvalilable247: Boolean?,
            @SerializedName("isHoliday")
            @Expose
            var isHoliday: Boolean?,
            @SerializedName("storeTimings")
            @Expose
            var storeTimings: List<StoreTiming?>?
        ) {
            data class StoreTiming(
                @SerializedName("closeTime")
                @Expose
                var closeTime: String?,
                @SerializedName("openTime")
                @Expose
                var openTime: String?
            )
        }

        data class ContactPerson(
            @SerializedName("email")
            @Expose
            var email: String?,
            @SerializedName("name")
            @Expose
            var name: String?,
            @SerializedName("phoneNumber")
            @Expose
            var phoneNumber: String?
        )

        data class DeliveryHour(
            @SerializedName("day")
            @Expose
            var day: String?,
            @SerializedName("isAvalilable247")
            @Expose
            var isAvalilable247: Boolean?,
            @SerializedName("isHoliday")
            @Expose
            var isHoliday: Boolean?,
            @SerializedName("storeTimings")
            @Expose
            var storeTimings: List<StoreTiming?>?
        ) {
            data class StoreTiming(
                @SerializedName("closeTime")
                @Expose
                var closeTime: String?,
                @SerializedName("openTime")
                @Expose
                var openTime: String?
            )
        }

        data class StoreService(
            @SerializedName("cod")
            @Expose
            var cod: Any?,
            @SerializedName("curbSide")
            @Expose
            var curbSide: Any?,
            @SerializedName("delivery")
            @Expose
            var delivery: Boolean?,
            @SerializedName("deliveryAreas")
            @Expose
            var deliveryAreas: List<DeliveryArea?>?,
            @SerializedName("deliveryId")
            @Expose
            var deliveryId: Any?,
            @SerializedName("deliveryRadius")
            @Expose
            var deliveryRadius: Int?,
            @SerializedName("driveThru")
            @Expose
            var driveThru: Any?,
            @SerializedName("dropInCar")
            @Expose
            var dropInCar: Boolean?,
            @SerializedName("pickup")
            @Expose
            var pickup: Boolean?,
            @SerializedName("rating")
            @Expose
            var rating: Double?,
            @SerializedName("sameBuildingDelivery")
            @Expose
            var sameBuildingDelivery: Any?,
            @SerializedName("siningStore")
            @Expose
            var siningStore: Boolean?
        ) {
            data class DeliveryArea(
                @SerializedName("areaName")
                @Expose
                var areaName: String?,
                @SerializedName("cityOid")
                @Expose
                var cityOid: Any?,
                @SerializedName("countryOid")
                @Expose
                var countryOid: Any?,
                @SerializedName("deliveryAreaOid")
                @Expose
                var deliveryAreaOid: Int?,
                @SerializedName("deliveryCodes")
                @Expose
                var deliveryCodes: Any?
            )
        }
    }
}