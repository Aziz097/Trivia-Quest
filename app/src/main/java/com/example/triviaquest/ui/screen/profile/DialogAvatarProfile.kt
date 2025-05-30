package com.example.triviaquest.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaquest.R
import com.example.triviaquest.data.common.avatarProfile
import com.example.triviaquest.data.common.backgroundProfile

@Composable
fun DialogAvatarProfile(
    avatar: Int,
    background: Int,
    onClick: (Int, Int) -> Unit
){

    var avatarState by remember {
        mutableStateOf(avatar)
    }

    var backgroundState by remember {
        mutableStateOf(background)
    }

    Column(
        Modifier
            .clip(shape = RoundedCornerShape(8))
            .background(Color.White)
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Choose Avatar",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        AvatarBox(
            avatarState = avatarState,
            onChange = { avatarState = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        ColorBox(
            backgroundState = backgroundState,
            onChange = { backgroundState = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { onClick(avatarState, backgroundState) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary_purple)
            )
        ) {
            Text(text = "Apply", fontSize = 24.sp)
        }
    }
}

@Composable
fun AvatarBox(
    avatarState: Int,
    onChange: (Int) -> Unit
){
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(4)
        , modifier = Modifier.padding(vertical = 12.dp)) {
        items(8){
            Surface(
                color = colorResource(id = R.color.gray_background),
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp)
                    .padding(horizontal = 4.dp)
                    .then(
                        if (avatarState == it) Modifier.border(
                            2.5.dp,
                            colorResource(id = R.color.primary_purple),
                            shape = RoundedCornerShape(20)
                        ) else Modifier
                    ),
                shape = RoundedCornerShape(20),
                onClick = { onChange(it) }
            ) {
                Image(
                    painter = painterResource(id = avatarProfile[it]!!),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(top = 10.dp)
                )
            }
        }
    }
}

@Composable
fun ColorBox(
    backgroundState: Int,
    onChange: (Int) -> Unit
){
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        columns = GridCells.Fixed(4),
        modifier = Modifier.padding(vertical = 12.dp)
    ){
        items(8){
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(50.dp)
                    .clip(shape = CircleShape)
                    .background(color = colorResource(id = backgroundProfile[it]!!))
                    .then(
                        if (backgroundState == it) Modifier.border(
                            2.5.dp,
                            colorResource(id = R.color.primary_purple),
                            shape = CircleShape
                        ) else Modifier
                    )
                    .clickable { onChange(it) }
            )
        }
    }
}
