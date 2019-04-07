interface Channel {
  fun id() : String
}

interface ChannelNameProvider {
  fun nameForChannel(channel: Channel): String
}