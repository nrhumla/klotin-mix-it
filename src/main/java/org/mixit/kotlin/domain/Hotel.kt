package org.mixit.kotlin.domain

import javax.persistence.*
import java.io.Serializable

@Entity
open class Hotel : Serializable {

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne(optional = false)
    var city: City? = null

    var name: String? = null
    var address: String? = null
    var zip: String? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    open var reviews: MutableSet<Review>? = null

}
