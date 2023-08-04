package org.jesperancinha.library.librarychannels.domain

import java.time.LocalDate
import java.util.UUID

data class ReaderUser(
    val id: UUID,
    val name:String,
    val address: String,
    val telephone: String,
)
data class Reservation (
    val id: UUID,
    val idUser: ReaderUser,
    val resevationDate: LocalDate = LocalDate.now(),
    val returnDate: LocalDate
)