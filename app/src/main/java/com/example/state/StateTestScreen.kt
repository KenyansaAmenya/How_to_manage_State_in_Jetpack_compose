package com.example.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.state.ui.theme.StateTestViewModel


// remember -> persist state on recomposition
// rememberSaveable -> persist state on configuration changes
// ViewModel and Livedata -> Hoist the state for re-usability

@Composable
fun StateTestScreen(viewModel: StateTestViewModel){
    val name by viewModel.name.observeAsState(initial = "")

    val surname by viewModel.surname.observeAsState(initial = "")

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        MyText("$name $surname")
        MyTextField(name, onNameChange = {
            viewModel.onNameUpdate(it)
        })
        MyTextField(surname, onNameChange = {
            viewModel.onSurNameUpdate(it)
        })
    }

}

@Composable
fun MyText(name : String){
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}


@Composable
fun MyTextField(name: String,onNameChange: (String) -> Unit){

    OutlinedTextField(
        value = name,
        onValueChange = {
                        onNameChange(it)
        },
        label ={Text(text = "Enter name")}
        )

}

