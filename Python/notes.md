1. _ has 3 main conventional uses in Python:
 * To hold the result of the last executed statement in an interactive interpreter session. This precedent was set by the standard CPython interpreter, and other interpreters have followed suit
 * For translation lookup in i18n (imported from the corresponding C conventions, I believe), as in code like: raise forms.ValidationError(_("Please enter a correct username"))
 * As a general purpose "throwaway" variable name to indicate that part of a function result is being deliberately ignored, as in code like: label, has_label, _ = text.partition(':')
<br />
The latter two purposes can conflict, so it is necessary to avoid using _ as a throwaway variable in any code block that also uses it for i18n translation (many folks prefer a double-underscore, __, as their throwaway variable for exactly this reason).
<br />
2. When a value is exactly halfway between two choices, the behavior of **round** is to round to the nearest even digit. That is, values such as 1.5 or 2.5 both get rounded to 2.
<br />
3.  The number of digit given to **round()** can be negative, in which case rounding takes place for tens, hundreds, and so on.
