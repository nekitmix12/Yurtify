package nekit.corporation.yurtify.ui_kit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nekit.corporation.yurtify.ui.theme.Brown300
import nekit.corporation.yurtify.ui.theme.Typography


@Composable
fun ConfirmButton(onClick: () -> Unit, text: String, modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Brown300
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 5.dp,
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text, Modifier.padding(vertical = 10.dp), style = Typography.bodyMedium)
    }
}