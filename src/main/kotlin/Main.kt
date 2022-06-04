fun main(args: Array<String>) {
    /*
     * Step1. 인사말 출력
     * Step2. 사용자 이름 입력받기
     * Step3. 입력받은 이름 출력
     * */

    println("안녕하세요. Shoppi에 오신 것을 환영합니다.")
    println("쇼핑을 계속 하시려면 이름을 입력해주세요:")

    val name = readLine()

    println("""
        안녕하세요, 반갑습니다. $name 님.
        원하시는 카테고리를 입력해주새요:
        ==================================
    """.trimIndent())
}