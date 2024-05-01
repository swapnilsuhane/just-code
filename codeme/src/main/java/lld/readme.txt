void view(String videoId) -> increment view count

videoId ->
101-

Map<videoId, count>

view latency: ~ 200 ms
topK api -> ~ 200 ms
total videos : few mils

max 30 sec delay
List<String> topK(int k) -> list of video ids

k max 200




"101" --> 578
102 --> 566
103 --> 400
104 --> 900
105 --> 35

topK(3) --> 101, 102, 104
topK(4) --> 101, 102, 103, 104