import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.senatvpeliculas.R
import com.example.senatvpeliculas.data.MovieData
import com.example.senatvpeliculas.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.movieTitle)
        val anio: TextView = view.findViewById(R.id.movieAnio)
        val gender: TextView = view.findViewById(R.id.movieGender)
        val director: TextView = view.findViewById(R.id.movieDirector)
        val poster: ImageView = view.findViewById(R.id.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]
        holder.title.text = movie.titulo
        holder.anio.text = movie.anioLanzamiento
        holder.director.text = movie.director
        val gender = MovieData.genders[movie.generoContenidoCodigo]
        if (gender != null) {
            holder.gender.text = gender
        }else {
            holder.gender.text = "Género desconocido"
        }
        Picasso.get().load(movie.imagenUrl).into(holder.poster)
    }

    override fun getItemCount(): Int = movies.size
}
