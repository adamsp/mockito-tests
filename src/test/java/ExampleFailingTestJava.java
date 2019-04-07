import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ExampleFailingTestJava {
  @Mock
  private ChannelNameProvider mockChannelNameProvider;
  @Mock
  private Channel mockChannel;

  @Before
  public void setup() {
    when(mockChannel.id()).thenReturn("ID");
    setupChannelName(mockChannel);
  }

  @Test
  public void exampleTest() {
  }

  private void setupChannelName(Channel channel) {
    // Works
//    String channelName = channel.id();
//    when(mockChannelNameProvider.nameForChannel(channel)).thenReturn(channelName);

    // Crashes
    when(mockChannelNameProvider.nameForChannel(channel)).thenReturn(channel.id());
  }
}
