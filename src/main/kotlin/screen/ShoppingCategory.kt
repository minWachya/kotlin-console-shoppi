package screen

class ShoppingCategory {
    // 카테고리 출력
    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물물품")
        for (category in categories) println(category)
        println("=> 장바구니로 이동하시혀면 #을 입력해주세요.")
        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("다시 입력해주세요.")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            // TODO 1. 장바구니 아동
        } else {
            if (categories.contains(selectedCategory)) {
                // TODO 2. 카테고리 상품 목록 보여주기
            } else showErrorMessage(selectedCategory)


        }
    }

    // 카테고리 목록에 없는 입력값을 받았을 때
    private fun showErrorMessage(selectedCategory: String?) {
        println("$selectedCategory : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        showCategories()
    }

}