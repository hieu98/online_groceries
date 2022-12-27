package com.hdt.booking.extension

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*


const val PATTERN_FORMAT_DATE_TAKEN_DETAIL = "yyyy/MM/dd(E)HH:mm"
const val PATTERN_FORMAT_DATE_TAKEN_INFO = "yyyy/MM/dd"
const val PATTERN_FORMAT_DATE_TAKEN_FULL= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val PATTERN_FORMAT_DATE_NOTICE = "yyyy/MM/dd (E)"


@RequiresApi(Build.VERSION_CODES.O)
fun nowUtc(): ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)
@RequiresApi(Build.VERSION_CODES.O)
fun nowUtcDay(): LocalDate = LocalDate.now()
@RequiresApi(Build.VERSION_CODES.O)
fun nowUtcMillis(): Long = nowUtc().toMillis()
@RequiresApi(Build.VERSION_CODES.O)
fun dateFromMillis(millis: Long): ZonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("UTC"))
@RequiresApi(Build.VERSION_CODES.O)
fun dateIsoStringFromMillis(millis: Long): String = dateFromMillis(millis).format(DateTimeFormatter.ISO_INSTANT)
@RequiresApi(Build.VERSION_CODES.O)
fun ZonedDateTime.toMillis() = this.toInstant().toEpochMilli()
@RequiresApi(Build.VERSION_CODES.O)
fun ZonedDateTime.toLocalZone(): ZonedDateTime = this.withZoneSameInstant(ZoneId.systemDefault())

fun epochToIso8601(time: Long,pattern : String): String {
    val sdf = SimpleDateFormat(pattern, Locale.JAPAN)
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(Date(time * 1000))
}
fun Date.formatDate(format: String = PATTERN_FORMAT_DATE_TAKEN_INFO): String {
    return SimpleDateFormat(format, Locale.JAPAN).format(this)
}

fun Calendar.formatTime(format: String): String {
    return String.format(Locale.getDefault(), format, this[Calendar.HOUR_OF_DAY], this[Calendar.MINUTE], this[Calendar.SECOND])
}
fun Long.toDate(): Date {
    val date = Date(this)
    val cal = Calendar.getInstance()
    cal.time = date
    return cal.time
}

fun formatDate(timeStamp: Long): Date {
    return Date(timeStamp * 1000L)
}