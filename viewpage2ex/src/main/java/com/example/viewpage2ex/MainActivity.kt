package com.example.viewpage2ex

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpage2ex.databinding.ActivityMainBinding
import com.example.viewpage2ex.databinding.ItemPagerXmlBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        datas.add("아이템 1")
        datas.add("아이템 2")
        datas.add("아이템 3")

//        // 뷰페이지 어댑터에 적용
//        binding.viewpager.adapter = MyPagerAdapter(datas)

            // 프래그먼트 어댑터 이용
        binding.viewpager.adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.orientation - ViewPager2.ORIENTATION_VERTICAL
        }
    }

// 프레그먼트 어댑터 이용
class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment())
    }
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}

// 뷰 홀더 준비
class MyPagerViewHolder(val binding: ItemPagerXmlBinding) : RecyclerView.ViewHolder(binding.root)

// 어댑터 준비
class MyPagerAdapter(val datas:MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    // 항목의 개수를 판단하려고 자동으로 호출됨
    override fun getItemCount(): Int = datas.size

    // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출됨
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyPagerViewHolder(ItemPagerXmlBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("test","onBindViewHolder: ${position}")
        val binding = (holder as MyPagerViewHolder).binding

        // 뷰에 데이터 출력
        binding.itemPagerTextView.text = datas[position]
        when (position % 3) {
            0 -> binding.itemPagerTextView.setBackgroundColor(Color.RED)
            1 -> binding.itemPagerTextView.setBackgroundColor(Color.BLUE)
            2 -> binding.itemPagerTextView.setBackgroundColor(Color.GREEN)
        }
    }
}
