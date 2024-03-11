package ba.unsa.etf.malasu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.unsa.etf.malasu.models.BoardSize
import ba.unsa.etf.malasu.models.MemoryCard
import ba.unsa.etf.malasu.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {


    private lateinit var rvBoard : RecyclerView
    private lateinit var tvNumMove : TextView
    private lateinit var tvNumPair : TextView
    private var boardSize = BoardSize.HARD;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBoard = findViewById(R.id.rvBoard)
        tvNumPair = findViewById(R.id.tvNumPairs)
        tvNumMove = findViewById(R.id.tvNumMoves)

        val chosenImages =  DEFAULT_ICONS.shuffled().take(boardSize.numCardPairs())
        val randomizeImages = (chosenImages + chosenImages).shuffled()
        randomizeImages.map { MemoryCard(it,isFaceUp = false,isMatched = false) }
        rvBoard.adapter = MemoryBoardAdapter(this,boardSize,randomizeImages)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.getWidht())
    }
}