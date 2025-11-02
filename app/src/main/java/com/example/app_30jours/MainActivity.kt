package com.example.app_30jours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class simple pour un conseil
data class Conseil(
    val jour: Int,
    val titre: String,
    val description: String,
    val imageRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleScoutApp()
        }
    }
}
@Preview
@Composable
fun SimpleScoutApp() {
    val conseils = remember { generateConseils() }

    Scaffold(
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(8.dp)
        ) {
            items(conseils) { conseil ->
                SimpleConseilCard(conseil)
            }
        }
    }
}

@Composable
fun SimpleConseilCard(conseil: Conseil) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Jour ${conseil.jour}", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = conseil.imageRes),
                contentDescription = conseil.titre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = conseil.titre, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

            if (expanded) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = conseil.description, fontSize = 14.sp)
            }
        }
    }
}

fun generateConseils(): List<Conseil> {
    val titres = listOf(
        "Respect de la nature",
        "Allumer un feu en sécurité",
        "Montage de tente",
        "Orientation",
        "Préparer son sac",
        "Économie d’eau",
        "Cuisine de camp",
        "Premiers secours",
        "Noeuds essentiels",
        "Lecture de carte",
        "Sécurité près de l’eau",
        "Gérer le froid",
        "Signaux d’urgence",
        "Respect des animaux",
        "Organisation du camp",
        "Hygiène en plein air",
        "Sécurité du feu",
        "Observation de la faune",
        "Bien dormir en tente",
        "Travail d’équipe",
        "Nettoyage du camp",
        "Randonnée nocturne",
        "Construire un abri",
        "Préparer un itinéraire",
        "Esprit d’entraide",
        "Transmission du savoir",
        "Préserver les ressources",
        "Lire la météo",
        "Camaraderie",
        "Célébrer les réussites"
    )

    val descriptions = listOf(
        "Ramasse les déchets et protège la nature.",
        "Prépare un foyer sûr et garde de l’eau à proximité.",
        "Monte ta tente solidement et choisis un bon emplacement.",
        "Apprends à lire une boussole et une carte.",
        "Emporte seulement l’essentiel pour alléger ton sac.",
        "Utilise l’eau avec soin et évite le gaspillage.",
        "Prépare des repas simples et équilibrés.",
        "Apprends les gestes de base pour aider les autres.",
        "Maîtrise les noeuds utiles pour le campement.",
        "Utilise la carte pour bien t’orienter.",
        "Reste prudent près des points d’eau.",
        "Habille-toi chaudement pour éviter le froid.",
        "Sache comment signaler une urgence.",
        "Observe sans déranger les animaux.",
        "Garde ton espace propre et organisé.",
        "Sois propre et garde ton camp sain.",
        "Surveille toujours ton feu et éteins-le bien.",
        "Regarde et écoute la nature attentivement.",
        "Installe bien ton couchage pour dormir confortablement.",
        "Travaille en équipe et soutiens les autres.",
        "Nettoie le camp avant de partir.",
        "Utilise une lampe frontale et reste ensemble.",
        "Apprends à construire un abri simple.",
        "Prévois ton parcours avant de partir.",
        "Aide et encourage tes camarades.",
        "Transmets ton savoir aux plus jeunes.",
        "Réduis, réutilise et recycle.",
        "Observe les signes du temps.",
        "Partage et profite des bons moments.",
        "Sois fier de chaque progrès !"
    )

    val images = listOf(
        R.drawable.jour1, R.drawable.jour2, R.drawable.jour3, R.drawable.jour4, R.drawable.jour5,
        R.drawable.jour6, R.drawable.jour7, R.drawable.jour8, R.drawable.jour9, R.drawable.jour10,
        R.drawable.jour11, R.drawable.jour12, R.drawable.jour13, R.drawable.jour14, R.drawable.jour15,
        R.drawable.jour16, R.drawable.jour17
    )

    return List(17) { i ->
        Conseil(jour = i + 1, titre = titres[i], description = descriptions[i], imageRes = images[i])
    }
}
