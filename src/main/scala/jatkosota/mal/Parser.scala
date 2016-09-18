package jatkosota.mal

import fastparse.all._

object Parser {
  val chars         = P( CharsWhile(!"\"\\".contains(_: Char)) )
  val digits        = P( CharsWhile('0' to '9' contains(_:Char)) )
  val space         = P( CharsWhile(" \r\n\t".contains(_: Char)).? )
  val hexDigit      = P( CharIn('0' to '9', 'a' to 'f', 'A' to 'F') )
  val unicodeEscape = P( "u" ~ hexDigit ~ hexDigit ~ hexDigit ~ hexDigit )
  val escape        = P( "\\" ~ (CharIn("\"/\\bfnrt") | unicodeEscape)  )

  val integral   = P( ("0" | CharIn('1' to '9') ~ digits.?) )
  val exponent   = P( CharIn("eE") ~ CharIn("+-").? ~ digits )
  val fractional = P( CharIn('0' to '9') ~ "." ~ digits.? )
  val number     = P( CharIn("+-").? ~ (integral | exponent | fractional) ).!

  val string     = P( "\"" ~ (chars | escape).rep.! ~ "\"" )
  val bool       = P( "true".! | "false".! )

  val identiferFirst = P(
    CharIn('a' to 'z', 'A' to 'Z', List('_', '-', '+', '*', '/', '#', '$', '&', '!', '?', '%', '|', '=', '^', ':')).!
  )
  val identifer = P(
    (identiferFirst ~ (identiferFirst | P(CharIn('0' to '9'))).rep).!
  )

  val expression: P[Any] = P( space ~ (atom | list) ~ space )
  val atom: P[Any]       = P( number | string | bool | identifer )
  val list: P[Any]       = P( "(" ~ expression.rep(sep=space) ~ ")" )
}
