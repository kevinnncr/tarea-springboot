package com.example.demo.service

import com.example.demo.entity.Client
import com.example.demo.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list(): List<Client> {
        return clientRepository.findAll()

    }
    fun save(client: Client): Client {
       return clientRepository.save(client)
    }
    fun update(client: Client): Client {
        try {
            clientRepository.findById(client.id)
                ?: throw Exception("id exist")
            return clientRepository.save(client)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(client: Client): Client {
        try {
            val response = clientRepository.findById(client.id)
                ?: throw Exception("id exist")
            response.apply {
                namecli= client.namecli
            }
            return clientRepository.save(client)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}