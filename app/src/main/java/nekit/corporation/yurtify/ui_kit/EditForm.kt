package nekit.corporation.yurtify.ui_kit

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import nekit.corporation.yurtify.ui.theme.Beige
import nekit.corporation.yurtify.ui.theme.Font
import nekit.corporation.yurtify.ui.theme.Gray
import nekit.corporation.yurtify.ui.theme.Typography

@Composable
fun EditForm(
    text: String,
    placeholder: String,
    @SuppressLint("ModifierParameter") modifier: Modifier,
    onChange: (String) -> Unit,
    textError: String?,
) {

    OutlinedTextField(
        value = text,
        onValueChange = onChange,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(placeholder) },
        supportingText = textError?.let { { Text(it, style = Typography.headlineSmall) } },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Beige,
            focusedContainerColor = Beige.copy(alpha = 0.9f),
            unfocusedBorderColor = Gray,
            focusedBorderColor = Gray,
            focusedTextColor = Font.copy(alpha = 0.8f),
            unfocusedTextColor = Font.copy(alpha = 0.7f),
            errorTextColor = Font.copy(alpha = 1f),
            focusedPlaceholderColor = Font.copy(alpha = 0.4f),
            unfocusedPlaceholderColor = Font.copy(alpha = 0.3f),
            focusedSupportingTextColor = Color.Red,
            unfocusedSupportingTextColor = Color.Red,
            errorContainerColor = Font.copy(alpha = 0.3f),
        ),
        textStyle = Typography.bodySmall, isError = textError != null
    )
}