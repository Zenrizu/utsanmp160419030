package id.ac.ubaya.informatika.mnchealthcare_160419030.model

data class Doctor(
    val id:String?,
    val name:String?,
    val email:String?,
    val age:String?,
    val jam_praktik:String?,
    val weekend:Boolean,
    val pengalaman:Int?,
    val description:String?,
    val photo_url:String?,
    val rating:Int
)
data class Obat(
    val nama:String?,
    val type:String?,
    val description: String?,
)
