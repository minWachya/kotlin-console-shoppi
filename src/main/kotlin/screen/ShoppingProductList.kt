package screen

import data.CartItems
import data.Product

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울바지"),
        Product("패션", "가을 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물물품", "건식사료"),
        Product("반려동물물품", "습식사료"),
        Product("반려동물물품", "치약"),
        Product("반려동물물품", "간식")
    )

    // 카테고리 이름 사용해 해당 상품 조회 가능한 변수
    private val categories: Map<String, List<Product>> = products.groupBy { products->
        products.categoryLabel
    }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                ***************************
                선택하신 {$selectedCategory} 카테고리 상품입니다.
            """.trimIndent())
            categoryProducts.forEachIndexed { index, product ->
                println("$index, ${product.name}")
            }
            
            showCartOption(categoryProducts, selectedCategory)
        }
        else showEmptyProductMessage(selectedCategory)
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String) {
        println("""
            ===================================
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent())

        val selectIndex = readLine()?.toIntOrNull()!!
        categoryProducts.getOrNull(selectIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주새요.")
            val answer = readLine()
            // 장바구니 이동
            if (answer == "#") {
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItem()
            } else if  (answer == "*") {    // 계속 쇼핑
                showProducts(selectedCategory)
            } else {
                // TODO: 다른 선택 처리
            }
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("$selectedCategory 카테고리의 상품이 등록되지 않았습니다.")
    }
}