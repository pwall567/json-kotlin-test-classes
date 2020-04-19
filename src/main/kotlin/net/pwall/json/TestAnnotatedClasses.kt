/*
 * @(#) TestAnnotatedClasses.kt
 *
 * json-kotlin-test-classes Test classes for json-kotlin, json-ktor etc.
 * Copyright (c) 2019, 2020 Peter Wall
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.pwall.json

import net.pwall.json.annotation.JSONAllowExtra
import net.pwall.json.annotation.JSONIgnore
import net.pwall.json.annotation.JSONIncludeAllProperties
import net.pwall.json.annotation.JSONIncludeIfNull
import net.pwall.json.annotation.JSONName

@Suppress("unused")
data class DummyWithIgnore(val field1: String, @JSONIgnore val field2: String = "defaulted", val field3: String)

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomIgnore

@Suppress("unused")
data class DummyWithCustomIgnore(val field1: String, @CustomIgnore val field2: String = "special", val field3: String)

@Suppress("unused")
class DummyWithNameAnnotation {

    var field1: String = "xxx"
    @JSONName("fieldX")
    var field2: Int = 111

    override fun equals(other: Any?): Boolean {
        return other is DummyWithNameAnnotation && field1 == other.field1 && field2 == other.field2
    }

    override fun hashCode(): Int {
        return field1.hashCode() xor field2.hashCode()
    }

}

@Suppress("unused")
data class DummyWithParamNameAnnotation(val field1: String, @JSONName("fieldX") val field2: Int)

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@Suppress("unused")
annotation class CustomName(val symbol: String)

@Suppress("unused")
data class DummyWithCustomNameAnnotation(val field1: String, @CustomName("fieldX") val field2: Int)

@Suppress("unused")
data class DummyWithIncludeIfNull(val field1: String, @JSONIncludeIfNull val field2: String?, val field3: String)

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomIncludeIfNull

@Suppress("unused")
data class DummyWithCustomIncludeIfNull(val field1: String, @CustomIncludeIfNull val field2: String?,
                                        val field3: String)

@JSONIncludeAllProperties
@Suppress("unused")
data class DummyWithIncludeAllProperties(val field1: String, val field2: String?, val field3: String)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomIncludeAllProperties

@CustomIncludeAllProperties
@Suppress("unused")
data class DummyWithCustomIncludeAllProperties(val field1: String, val field2: String?, val field3: String)

@JSONAllowExtra
@Suppress("unused")
data class DummyWithAllowExtra(val field1: String, val field2: Int)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomAllowExtraProperties

@CustomAllowExtraProperties
@Suppress("unused")
data class DummyWithCustomAllowExtra(val field1: String, val field2: Int)
