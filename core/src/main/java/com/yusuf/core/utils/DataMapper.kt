package com.yusuf.core.utils


import com.yusuf.core.data.local.ClubEntity
import com.yusuf.core.data.remote.response.ClubResponse
import com.yusuf.core.domain.Club

object DataMapper {
    fun mapResponsesToEntities(input: List<ClubResponse>): List<ClubEntity> {
        val clubList = ArrayList<ClubEntity>()
        input.map {
            val club = ClubEntity(
                clubId = it.id,
                name = it.name,
                description = it.description,
                stadium = it.stadium,
                stadiumImage = it.stadiumImage,
                logo = it.logo,
                isFavorite = false
            )
            clubList.add(club)
        }
        return clubList
    }

    fun mapEntitiesToDomain(input: List<ClubEntity>): List<Club> =
        input.map {
            Club(
                clubId = it.clubId,
                name = it.name,
                description = it.description,
                stadium = it.stadium,
                stadiumImage = it.stadiumImage,
                logo = it.logo,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Club) = ClubEntity(
        clubId = input.clubId,
        name = input.name,
        description = input.description,
        stadium = input.stadium,
        stadiumImage = input.stadiumImage,
        logo = input.logo,
        isFavorite = input.isFavorite
    )
}