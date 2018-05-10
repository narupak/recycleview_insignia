package com.example.narupak.recycleview_insignia;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("leaves/Service_Approvedoc/approveList")
    Call <List<ApproveList>> getApproveListDataList();


}
