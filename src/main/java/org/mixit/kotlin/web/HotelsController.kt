package org.mixit.kotlin.web

import org.mixit.kotlin.domain.Hotel
import org.mixit.kotlin.service.HotelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class HotelsController {

    val hotelService: HotelService

    @Autowired
    constructor(hotelService: HotelService) {
        this.hotelService = hotelService
    }

    data class HotelDto(
            val id: Long,
            val name: String,
            val address: String,
            val zip: String,
            val city: String,
            val country: String
    )

    fun Hotel.toDto(): HotelDto = HotelDto(
            id!!,
            name ?: "",
            address ?: "",
            zip ?: "",
            city?.name ?: "",
            city?.country ?: ""
    )

    @RequestMapping("/api/hotels", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getHotels() = hotelService.hotels.map {
        it.toDto()
    }

    data class ChangeNameCommand(var name: String)

    @RequestMapping("/api/hotels/{id}", method = arrayOf(RequestMethod.PUT))
    @ResponseBody
    fun changeName(@PathVariable id: Long, @RequestBody command: ChangeNameCommand) {
        println(command)
    }

}







