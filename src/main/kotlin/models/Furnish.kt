package src.main.kotlin.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

//@Serializable
@JacksonXmlRootElement(localName = "furnish")
enum class Furnish {
    @JacksonXmlText
    FINE,
    @JacksonXmlText
    BAD,
    @JacksonXmlText
    LITTLE
}