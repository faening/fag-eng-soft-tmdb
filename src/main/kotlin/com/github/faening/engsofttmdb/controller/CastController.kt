package com.github.faening.engsofttmdb.controller

import com.github.faening.engsofttmdb.data.model.db.CastEntity
import com.github.faening.engsofttmdb.domain.model.Cast
import com.github.faening.engsofttmdb.domain.service.CastService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Suppress("unused")
@RestController
@RequestMapping("/casts")
class CastController @Autowired constructor(
    service: CastService
) : BaseController<CastEntity, Cast, Cast>(service)