package screen

import extensions.getNotEmptyString

class ShoppingCategory: Screen() {
    // 카테고리 출력
    fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물물품")
        for (category in categories) println(category)
        println("=> 장바구니로 이동하시혀면 #을 입력해주세요.")
        val selectedCategory = readLine().getNotEmptyString()
        // 장바구니 이동
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItem()
        } else {    // 선택한 카테고리 이동
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            } else showErrorMessage(selectedCategory)
        }
    }

    // 카테고리 목록에 없는 입력값을 받았을 때
    private fun showErrorMessage(selectedCategory: String?) {
        println("$selectedCategory : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        showCategories()
    }

}