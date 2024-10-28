import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lat.pam.utsproject.Food
import lat.pam.utsproject.R

class FoodAdapter(
    private val foodList: List<Food>,
    private val onItemClick: (Food) -> Unit // Pass a lambda for the click listener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodName.text = food.name
        holder.foodDescription.text = food.description
        holder.foodImage.setImageResource(food.imageResourceId)

        // Set click listener for each item
        holder.itemView.setOnClickListener {
            onItemClick(food) // Pass the food item to the click listener
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
    }
}
