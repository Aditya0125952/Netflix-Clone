package com.example.netflix_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 20.dp)
                .verticalScroll(rememberScrollState())
                ){
               App_Bar()
               displayingtab()
                Single_anime()
                most_popular_animes()
                yet_to_watch()
            }
        }
    }
}

@Composable
fun App_Bar(){
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        Image(painter = painterResource(id = R.drawable.netflixicon),
            contentDescription ="icon",
            modifier = Modifier.size(60.dp)
            )
        Row (){
            Image(painter = painterResource(id = R.drawable.app_bar_search),
                contentDescription ="search",
                modifier = Modifier
                    .padding(end = 14.dp)
                    .size(28.dp)
                    )
            Image(painter = painterResource(id = R.drawable.app_bar_profile),
                contentDescription ="profile",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(28.dp))
        }

    }
}

@Composable
fun displayingtab(){
     Row (modifier = Modifier
         .fillMaxWidth()
         .background(Color.Black)
         .padding(top = 10.dp, start = 20.dp, end = 20.dp),
         horizontalArrangement = Arrangement.SpaceBetween){
          Text(text = "TV Shows",
               color = Color.LightGray,
              fontSize = 17.sp
              )
         Text(text = "Movies",
             color = Color.LightGray,
             fontSize = 17.sp
         )

         Row {
             Text(text = "Catogeries",
                 color = Color.LightGray,
                 fontSize = 17.sp
                 )
             Image(painter = painterResource(id = R.drawable.drop_icon),
                 contentDescription = "drop icon",
                 modifier = Modifier.padding(start = 6.dp))
         }
     }
}

@Composable
fun Single_anime(){
   Column(modifier = Modifier
       .fillMaxWidth()
       .background(Color.Black)
       .padding(bottom = 7.dp),
       horizontalAlignment = Alignment.CenterHorizontally
   ) {

        Image(painter = painterResource(id = R.drawable.blackclover),
            contentDescription ="top anime",
            modifier = Modifier
                .width(300.dp)
                .height(350.dp)
                .padding(top = 60.dp),
        )

       Row (modifier = Modifier
           .fillMaxWidth()
           .background(Color.Black)
           .padding(start = 60.dp, end = 60.dp, top = 60.dp, bottom = 15.dp),
           horizontalArrangement = Arrangement.SpaceBetween
           ){
         Text(text = "magic",
             color = Color.White
             )
           Text(text = "Adventure",
               color = Color.White
           )
           Text(text = "comedy",
               color = Color.White
           )
           Text(text = "super natural",
               color = Color.White
           )
       }

       Row (modifier = Modifier
           .fillMaxWidth()
           .background(Color.Black)
           .padding(start = 80.dp, end = 80.dp, top = 20.dp),
           horizontalArrangement = Arrangement.SpaceBetween){
           Column(horizontalAlignment = Alignment.CenterHorizontally){
               Image(painter = painterResource(id = R.drawable.baseline_add_24),
                   contentDescription ="add button",
                   modifier = Modifier.size(30.dp))
               Text(text = "My List",
                   color = Color.LightGray,
                   fontSize = 10.sp)
           }
           Button(onClick ={},
                 colors =ButtonDefaults.buttonColors(Color.White),
               shape = RoundedCornerShape(6.dp)
               ) {
               Text(text = "Play",
                    color = Color.Black,
                   fontSize = 18.sp
                   )
           }

           Column(horizontalAlignment = Alignment.CenterHorizontally){
               Image(painter = painterResource(id = R.drawable.app_info),
                   contentDescription ="add button",
                   modifier = Modifier.size(30.dp))
               Text(text = "Info",
                   color = Color.LightGray,
                   fontSize = 10.sp)
           }
       }

   }
}

@SuppressLint("SuspiciousIndentation")
@Composable
@Preview
fun most_popular_animes(){
  val most_popular_movies= mutableListOf<mostPopular>()
    most_popular_movies.add(mostPopular("Jujutsu Kaisen",R.drawable.jujutsu))
    most_popular_movies.add(mostPopular("All Out",R.drawable.allout))
    most_popular_movies.add(mostPopular("Haiyku",R.drawable.haiyku))
    most_popular_movies.add(mostPopular("My Hero Academia",R.drawable.myheroacademia))
    most_popular_movies.add(mostPopular("Naruto",R.drawable.naruto))
    Column (modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(top = 30.dp),
        verticalArrangement = Arrangement.Bottom
        ){
        Text(text = "Most Viewed :",
               color = Color.White,
                fontSize =22.sp,
             fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
            )
        LazyRow(modifier = Modifier.padding(top = 10.dp)) {
            itemsIndexed(most_popular_movies){index, item->
                RecyclerView_Mostpopular(name = item.movieName, Image = item.movieImage)

            }
        }
    }


}


@Composable
fun RecyclerView_Mostpopular(
    name :String,
    Image:Int
){
    Column (
        Modifier
            .background(Color.Black)
            .padding(horizontal = 8.dp, vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = Image),
            contentDescription ="anime",
            modifier = Modifier
                .width(150.dp)
                .height(210.dp)
            )
        Text(text = name,
             color = Color.White,
            fontSize = 17.sp,
            modifier = Modifier.padding(horizontal = 3.dp)
                .padding(top = 5.dp)
            )
    }
}

data class mostPopular(
    val movieName:String,
    val movieImage:Int

)

data class yetToWatch(
    val movieName:String,
    val movieImage:Int
)


@Composable
fun yet_to_watch(){
    val yetToWatch= mutableListOf<yetToWatch>()
    yetToWatch.add(yetToWatch("Blue Lock",R.drawable.bluelock))
    yetToWatch.add(yetToWatch("Death Note",R.drawable.deathnote))
    yetToWatch.add(yetToWatch("Musukotensi",R.drawable.muskotensi))
    yetToWatch.add(yetToWatch("DxD",R.drawable.highschool))
    yetToWatch.add(yetToWatch("One Piece",R.drawable.onepiece))
    yetToWatch.add(yetToWatch("Fairy Tail",R.drawable.fairytail))

    Column (modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(top = 30.dp),
        verticalArrangement = Arrangement.Bottom
    ){
        Text(text = "Yet To Watch :",
            color = Color.White,
            fontSize =22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )
        LazyRow(modifier = Modifier.padding(top=10.dp)) {
            itemsIndexed(yetToWatch){index, item->
                RecyclerView_Mostpopular(name = item.movieName, Image = item.movieImage)

            }
        }
    }
}