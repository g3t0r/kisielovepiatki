package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.Kissel
import pl.kisielovepiatki.backend.repository.KisselRepository
import pl.kisielovepiatki.backend.service.domain.KisselService
import pl.kisielovepiatki.backend.validator.KisselValidator

@Component
class KisselServiceImpl(
    repository: KisselRepository,
    validator: KisselValidator
) : KisselService, GenericEntityServiceImpl<Kissel, Int>(
    repository,
    validator
)
