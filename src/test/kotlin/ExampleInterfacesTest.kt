import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class ExampleFailingTestKotlin {
  @Mock
  private lateinit var mockChannelNameProvider: ChannelNameProvider
  @Mock
  private lateinit var mockChannel: Channel

  @Before
  fun setup() {
    `when`(mockChannel.id()).thenReturn("ID")
    `when`(mockChannelNameProvider.nameForChannel(mockChannel)).thenReturn(mockChannel.id())
  }

  @Test
  fun exampleTest() = Unit

  private fun setupChannelName(channel: Channel) {
    // Works
//    val channelName = channel.id()
//    `when`(mockChannelNameProvider.nameForChannel(channel)).thenReturn(channelName)

    // Crashes
    `when`(mockChannelNameProvider.nameForChannel(channel)).thenReturn(channel.id())
  }
}