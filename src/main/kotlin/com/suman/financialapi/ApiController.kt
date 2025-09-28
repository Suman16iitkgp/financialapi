package com.suman.financialapi

import org.springframework.web.bind.annotation.*
import com.suman.financialapi.dto.DealState



@RestController
class ApiController (private val apiService: ApiService) {
    
    @GetMapping("/participateion/{id}")
    fun getParticipation(@PathVariable id: Long) : String {
        return apiService.getParticipation(id)
    }


    @PostMapping("/requestParticipation")
    fun requestParticipation(@RequestBody id: Long) : String {
            return apiService.createParticipation(id)
    }

    @PutMapping("/updateParticipation/{id}")
    fun updateParticipation(@PathVariable id: Long, @RequestBody dealState : DealState) : String {
            return apiService.updateParticipation(id, dealState)
    }   
    
    @DeleteMapping("/deleteParticipation/{id}")
    fun deleteParticipation(@PathVariable id: Long) : String {
            return apiService.deleteParticipation(id)
    }

}