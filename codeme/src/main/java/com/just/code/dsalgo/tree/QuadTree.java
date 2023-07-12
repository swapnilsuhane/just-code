package com.just.code.dsalgo.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class QuadTree {
    QuadTree north;
    QuadTree south;
    QuadTree east;
    QuadTree west;

    //[0,0] to [+100,+100]
    Double latitudeFrom;
    Double longitudeFrom;
    Double latitudeTo;
    Double longitudeTo;
}

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
class CycleGeoLocation {
    String cycleId;
    Double latitude;
    Double longitude;
}
