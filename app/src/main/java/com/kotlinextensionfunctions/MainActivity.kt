package com.kotlinextensionfunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kotlinextensionfunctions.ui.theme.KotlinExtensionFunctionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinExtensionFunctionsTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//region Extension Functions
//example 1
fun String.RemoveFirstLastChars():String {
    return this.substring(1,this.length-1);
}
fun String.RemoveFirstLastChars_V2():String = this.substring(1,this.length-1);

//example 2
fun String.getAllWordsInQuery():List<String>{
    return this.split(" ");
}

//example 3
class Telephone(
    val number:String
)
fun Telephone.call(): Int {
    var x= number.toInt()+9
    return x;
}
//endregion

//region Composable Functions
@Composable
fun MyApp(modifier:Modifier=Modifier){
    Surface(
        modifier ,
        color = MaterialTheme.colorScheme.background
    ) {

        Column (
            modifier=modifier.fillMaxSize(),
            verticalArrangement =Arrangement.Top,
            horizontalAlignment =Alignment.Start
        ){
            val input:String ="I Like Android"
            val tele = Telephone("25")
            showRemovedFirstLastChars(input.RemoveFirstLastChars())
            showgetAllWordsInQuery(input.getAllWordsInQuery())
            access_member_properties(tele.call().toString())
        }


    }
}

@Composable
fun showRemovedFirstLastChars(input:String){
    Text(
        text = "Result = $input",
        fontSize = 24.sp ,
        color = Color.Red
    )
}

@Composable
fun showgetAllWordsInQuery(input: List<String>){
    Text(
        text = "Result = $input",
        fontSize = 24.sp ,
        color = Color.Red
    )
}

@Composable
fun access_member_properties(input: String){
    Text(
        text = "Result = $input",
        fontSize = 24.sp ,
        color = Color.Red
    )
}
//endregion

//region Preview Area
@Preview(showBackground = true)
@Composable
fun RemoveFirstLastCharsPreview() {
    KotlinExtensionFunctionsTheme {
        val input:String ="I Like Android"
        showRemovedFirstLastChars(input.RemoveFirstLastChars())
    }
}

@Preview(showBackground = true)
@Composable
fun getAllWordsInQueryPreview() {
    KotlinExtensionFunctionsTheme {
        val input:String ="I Like Android"
        showgetAllWordsInQuery(input.getAllWordsInQuery())
    }
}


@Preview(showBackground = true)
@Composable
fun access_member_propertiesPreview() {
    KotlinExtensionFunctionsTheme {
        val tele = Telephone("25")
        access_member_properties(tele.call().toString())
    }
}
//endregion
