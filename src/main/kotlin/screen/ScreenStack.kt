package screen

// 프로젝트 전역에서 화면 이동 관리함
object ScreenStack {
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen) = screenStack.add(screen)
    fun pop() = screenStack.removeLastOrNull()
    fun peek(): Screen? = screenStack.lastOrNull()
}

// ScreenStack 관리하는 Screen 타입을 sealed class로 추가
// 모든 screen들이 Screen의 서브 클래스
sealed class Screen
