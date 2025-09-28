package com.suman.financialapi

import org.springframework.stereotype.Service
import com.suman.financialapi.dto.DealState
import com.suman.financialapi.dto.Deal
import com.suman.financialapi.repository.DealRepository
import com.suman.financialapi.dto.Status


@Service
class ApiService (var repository : DealRepository) {
    
    fun getParticipation(id : Long): String {
        return repository.findById(id).map { deal ->
            "Deal ID: ${deal.dealId}, Name: ${deal.dealName}, Status: ${deal.status}, Version: ${deal.version}, Comments: ${deal.comments}"
        }.orElse("Participation with ID $id not found.")
    }

    fun createParticipation(id : Long): String {
        val savedDeal = repository.save( Deal(dealId = id, status = Status.PENDING, dealName = "OpenAI", version = 0, comments = "New participation request") )

        if( savedDeal.dealId != null ) {
            return "Participation with ID ${savedDeal.dealId} created successfully."
        }else{
            return "Failed to create participation."
        }
    }

    fun updateParticipation(id: Long, dealState : DealState ): String {
        return if (repository.existsById(id)) {
            val existingDeal = repository.findById(id).get()
            if( existingDeal.version == dealState.version ) {
                val updatedDeal = existingDeal.copy(
                    status = dealState.state,
                    comments = dealState.comments,
                    version = existingDeal.version + 1
                )
                repository.save(updatedDeal)
                "Participation with ID $id updated successfully."
            } else {
                "Version mismatch for Participation with ID $id. Current version is ${existingDeal.version}."
            }
        } else {
            "Participation with ID $id not found."
        }
    }

    fun deleteParticipation(id: Long) : String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Participation with ID $id deleted successfully."
        } else {
            "Participation with ID $id not found."
        }        
    }
}