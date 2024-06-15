package com.github.faening.engsofttmdb.domain.service

import com.github.faening.engsofttmdb.data.model.db.ReviewEntity
import com.github.faening.engsofttmdb.data.repository.ReviewRepository
import com.github.faening.engsofttmdb.domain.contract.BaseService
import com.github.faening.engsofttmdb.domain.mapper.ReviewMapper
import com.github.faening.engsofttmdb.domain.model.Review
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReviewService @Autowired constructor(
    private val repository: ReviewRepository,
    private val mapper: ReviewMapper
) : BaseService<ReviewEntity, Review, Review> {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun getAllEntities(): List<ReviewEntity> {
        return repository.findAll()
    }

    override fun getAll(): List<Review> {
        getAllEntities().let {
            return it.map { review -> mapper.fromEntityToDomain(review) }
        }
    }

    override fun getEntityById(id: Long): ReviewEntity {
        return repository.findById(id).orElseThrow { throw RuntimeException("Crew not found") }
    }

    override fun getById(id: Long): Review {
        getEntityById(id).let {
            return mapper.fromEntityToDomain(it)
        }
    }

    override fun saveEntity(entity: ReviewEntity): ReviewEntity {
        if (entity.id != null && entityManager.contains(entity).not()) {
            return repository.save(entityManager.merge(entity))
        }
        return repository.save(entity)
    }

    override fun saveAllEntities(entities: List<ReviewEntity>): List<ReviewEntity> {
        return entities.map { saveEntity(it) }
    }

    override fun save(request: Review): Review {
        request.let {
            val savedEntity = saveEntity(mapper.fromDomainToEntity(it))
            return mapper.fromEntityToDomain(savedEntity)
        }
    }

    override fun saveAll(request: List<Review>): List<Review> {
        request.let {
            val entities = request.map { mapper.fromDomainToEntity(it) }
            val savedEntities = saveAllEntities(entities)
            return savedEntities.map { mapper.fromEntityToDomain(it) }
        }
    }

    override fun updateEntity(entity: ReviewEntity): Review {
        entity.let {
            val updatedEntity = repository.save(it)
            return mapper.fromEntityToDomain(updatedEntity)
        }
    }

    override fun update(id: Long, request: Review): Review {
        id.let {
            val entity = getEntityById(it)
            val mergedEntity = mapper.mergeEntityAndRequest(entity, request)
            return updateEntity(mergedEntity)
        }
    }

    override fun deleteEntity(entity: ReviewEntity): Boolean {
        entity.let {
            repository.delete(it)
            return true
        }
    }

    override fun delete(id: Long): Boolean {
        id.let {
            val entity = getEntityById(it)
            return deleteEntity(entity)
        }
    }

}