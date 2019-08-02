
import android.text.TextPaint

class WordBreak{

    companion object {

        @JvmStatic
        fun getWordBreak(span: String, paint: TextPaint, width: Float): String {
            var value = ""
            val arr: List<String> = span.split(" ")
            var line = ""
            for (a in arr) {
                val str = line + a
                val end = paint.breakText(
                        str, true, width, null)
                if ((end > 0 && end < str.length)) {
                    value += (line.replace("\n", "") + "\n")
                    line = "$a "
                } else {
                    line += "$a "
                }

                if (line.contains("\n")) {
                    value += line.trim() + "\n"
                    line = ""
                }
            }
            value += line
            return value
        }
    }
}
