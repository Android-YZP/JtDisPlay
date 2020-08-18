package com.jt.display.http;

import com.jt.display.base.JsonResult;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
//
//    //用户登录
//    @POST("jwms-auth/oauth/token")
//    Flowable<LoginDataBean> login(@Header("Authorization") String authorization,
//                                  @Header("Content-Type") String ContentType,
//                                  @Header("Tenant-Id") String TenantId,
//                                  @Query("grant_type") String grant_type,
//                                  @Query("username") String username,
//                                  @Query("password") String password,
//                                  @Query("scope") String scope,
//                                  @Query("tenantid") String Tenant_id);
//
//    //选择仓库
//    @GET("/jwms-basic-data/warehouse_users")
//    Flowable<JsonResult> warehouse_users(@Query("account") String account,
//                                         @Query("tenantId") String tenantId);
//
//
//    /**
//     * 选择上架功能
//     */
//
//
//    //效验容器  blade-auth就是token
//    @GET("/jwms-inbound/putaway/actions/scan_container_code")
//    Flowable<JsonResult> scan_container_code(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                             @Query("containerCode") String containerCode,
//                                             @Query("warehouseId") String warehouseId);
//
//    //查询容器内库存数据  blade-auth就是token
//    @GET("/jwms-inventory/realtime_inventory/container_inventory")
//    Flowable<JsonResult> container_inventory(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                             @Query("containerCode") String containerCode,
//                                             @Query("warehouseId") String warehouseId);
//
//
//    //上架详情 warehouseId  containerCode  效验商品码 warehouseId containerCode commodityCode
//    @GET("/jwms-inventory/realtime-inventory/page")
//    Flowable<JsonResult> page(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                              @Query("containerCode") String account,
//                              @Query("warehouseId") String tenantId);
//
//    //显示推荐储位编码
//    @GET("/jwms-inbound/putaway/recommended_storage_location")
//    Flowable<JsonResult> recommended_storage_location(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                                      @Query("commodityId") String commodityId,
//                                                      @Query("warehouseId") String warehouseId);
//
//
//    //扫描储位编码，后端校验是否可以用于上架并，返回载具信息
//    @GET("/jwms-inbound/putaway/actions/scan_storage_location_code")
//    Flowable<JsonResult> scan_storage_location_code(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                                    @Query("storageLocationCode") String storageLocationCode,
//                                                    @Query("warehouseId") String warehouseId);
//
//    //输入上架数量
//
//    //提交上架操作
//    @POST("/jwms-inbound/putaway")
//    Flowable<JsonResult> putaway(@Header("Authorization") String authorization,
//                                 @Header("blade-auth") String blade_auth,
//                                 @Body PutawayBean bean);
//
//
//    /**
//     * 选择收货（验收）功能
//     */
//
//    //验收列表
//    @GET("/jwms-inbound/inbound_receipts/unfinished_receipts")
//    Flowable<JsonResult> unfinished_receipts(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                             @Query("warehouseId") String warehouseId);
//
//    //验收详情
//    @GET("/jwms-inbound/inbound_receipts/actions/search_by_code")
//    Flowable<JsonResult> y_search_by_code(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                          @Query("receiptCode") String receiptCode,
//                                          @Query("warehouseId") String warehouseId);
//
//    //校验容器码是否存在且可用,获取详情数据
//    @GET("/jwms-basic-data/unit_loads/actions/search_by_code")
//    Flowable<JsonResult> r_search_by_code(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                          @Query("code") String containerCode,
//                                          @Query("unitLoadType") String unitLoadType,
//                                          @Query("warehouseId") String warehouseId);
//
//    //结束入库单
//    @GET("/jwms-inbound/inbound_receipts/actions/finish")
//    Flowable<JsonResult> finish(@Header("Authorization") String authorization, @Header("blade-auth") String blade_auth,
//                                @Query("id") String id,
//                                @Query("warehouseId") String warehouseId);
//
//    //提交收货操作
//
//    @POST("/jwms-inbound/receiving")
//    Flowable<JsonResult> receiving(@Header("Authorization") String authorization,
//                                   @Header("blade-auth") String blade_auth,
//                                   @Body ReceivingBean bean);
//
//    /**
//     * 拣货
//     */
//    //出库单列表
//    @GET("/jwms-outbound/picking_tasks/pickable/page")
//    Flowable<JsonResult> pickablePage(@Header("Authorization") String authorization,
//                                      @Header("blade-auth") String blade_auth,
//                                      @Query("warehouseId") String warehouseId,
//                                      @Query("asc") boolean asc,
//                                      @Query("current") String current,
//                                      @Query("size") String size);
//
//    //扫描出库单
//    @GET("/jwms-outbound/picking/actions/scan_outbound_receipt")
//    Flowable<JsonResult> scan_outbound_receipt(@Header("Authorization") String authorization,
//                                               @Header("blade-auth") String blade_auth,
//                                               @Query("warehouseId") String warehouseId,
//                                               @Query("outboundReceiptCode") String outboundReceiptCode);
//
//    //容器号检查
//    @GET("/jwms-outbound/picking/actions/scan_container_code")
//    Flowable<JsonResult> picking_scan_container_code(@Header("Authorization") String authorization,
//                                                     @Header("blade-auth") String blade_auth,
//                                                     @Query("warehouseId") String warehouseId,
//                                                     @Query("containerCode") String containerCode);
//
//    //退出拣货
//    @GET("/jwms-outbound/picking/actions/exit")
//    Flowable<JsonResult> exit(@Header("Authorization") String authorization,
//                              @Header("blade-auth") String blade_auth,
//                              @Query("warehouseId") String warehouseId,
//                              @Query("outboundReceiptCode") String outboundReceiptCode);
//
//    //B2B模式完成出库
//    @GET("/jwms-outbound/outbound_receipts/actions/b2b/finish_outbound")
//    Flowable<JsonResult> finish_outbound(@Header("Authorization") String authorization,
//                                         @Header("blade-auth") String blade_auth,
//                                         @Query("warehouseId") String warehouseId,
//                                         @Query("outboundReceiptCode") String outboundReceiptCode);
//
//    //提交拣货
//    // {
//    //	"cargoOwnerCode": "",
//    //	"commodityCode": "",
//    //	"containerCode": "",
//    //	"outboundReceiptCode": "",
//    //	"pickAmount": 0,
//    //	"storageLocationCode": "",
//    //	"warehouseId": 0
//    //}
//
//    @POST("/jwms-outbound/picking")
//    Flowable<JsonResult> picking(@Header("Authorization") String authorization,
//                                 @Header("blade-auth") String blade_auth,
//                                 @Body PickGoodsBean bean);


//    @POST("app/send/scanlog")
//    Flowable<JsonResult> sendScanLog(@Header("Authorization") String authorization, @Header("Token") String token, @Body List<ScanCarton> list);
//
//    @POST("app/modify/waybill")
//    Flowable<JsonResult> modifyWaybill(@Header("Authorization") String authorization, @Header("Token") String token, @Body Waybill waybill);
//
//    @GET("app/query/deliver/truck")
//    Flowable<JsonResult> getDeliverTruck(@Header("Authorization") String authorization, @Header("Token") String token);
//
//    @POST("app/add/deliver/waybill")
//    Flowable<JsonResult> addDeliverCar(@Header("Authorization") String authorization, @Header("Token") String token, @Body AddCar addCar);
//
//    @POST("app/generate/receipt")
//    Flowable<JsonResult> generateReceipt(@Header("Authorization") String authorization, @Header("Token")
//    String token, @Body GenerationBean generationBean);
//
//    @POST("app/query/store/city")
//    Flowable<JsonResult> getStoreCityList(@Header("Authorization") String authorization, @Header("Token") String token);
//
//    @POST("app/query/forwarder/waybill")
//    Flowable<JsonResult> getForwarderWaybillList(@Header("Authorization") String authorization, @Header("Token") String token, @Body Map<String, String> map);
//
//    @POST("app/query/waybill/sku")
//    Flowable<JsonResult> getWaybillSkuList(@Header("Authorization") String authorization, @Header("Token") String token, @Body Map<String, String> map);
//
//    @Multipart
//    @POST("app/upload/forwarder/waybill")
//    Flowable<JsonResult> uploadForwarderWaybill(@Header("Authorization") String authorization
//            , @Header("Token") String token, @Part("content") GxWaybill gxWaybill, @PartMap Map<String, RequestBody> map);
//
//    @Multipart
//    @POST("app/upload/jd/receivereport")
//    Flowable<JsonResult> uploadJdReceiveReport(@Header("Authorization") String authorization, @Header("Token") String token
//            , @Part("content") ReceiveReport receiveReport, @PartMap Map<String, RequestBody> map);
//
//    @POST("app/query/intransit/truck")
//    Flowable<JsonResult> getIntransitTruck(@Header("Authorization") String authorization, @Header("Token") String token, @Body TruckBean truckBean);
//
//    @Multipart
//    @POST("app/upload/driver/deliveryreceipt")
//    Flowable<JsonResult> uploadDriverDeliveryReceipt(@Header("Authorization") String authorization, @Header("Token") String token, @Part("content") CarReceiveReport carReceiveReport, @PartMap Map<String, RequestBody> map);
//
//    @Multipart
//    @POST("app/returns/upload/deliveryreceipt")
//    Flowable<JsonResult> uploadReturnsStoreDeliveryReceipt(@Header("Authorization") String authorization, @Header("Token") String token, @Part("content") SkuBean skuBean, @PartMap Map<String, RequestBody> map);
//
//    @POST("app/returns/query/waybill/sku")
//    Flowable<JsonResult> getReturnsSkuListByWaybill(@Header("Authorization") String authorization, @Header("Token") String token, @Body SkuBean skuBean);
//
//    @POST("app/query/waybill/sku")
//    Flowable<JsonResult> getSkuListByWaybill(@Header("Authorization") String authorization, @Header("Token") String token, @Body SkuBean skuBean);
//
//    @POST("app/returns/send/packinglist")
//    Flowable<JsonResult> sendReturnsPackingList(@Header("Authorization") String authorization, @Header("Token") String token, @Body CartonGoods cartonGoods);
//
//    @POST("app/returns/modify/waybill")
//    Flowable<JsonResult> modifyReturnsWaybill(@Header("Authorization") String authorization, @Header("Token") String token, @Body Waybill waybill);
//
//    @POST("app/returns/query/scancode")
//    Flowable<JsonResult> getReturnsScanList(@Header("Authorization") String authorization, @Header("Token") String token, @Body Map<String, String> map);
//
//    @POST("app/returns/returns/scan")
//    Flowable<JsonResult> sendReturnsScanLog(@Header("Authorization") String authorization, @Header("Token") String token, @Body List<ScanCarton> list);
//
//    @POST("app/return/query/packinglist")
//    Flowable<JsonResult> getPackingSkuList(@Header("Authorization") String authorization, @Header("Token") String token, @Body Map<String, String> map);
//
//    @POST("app/upgrade")
//    Flowable<JsonResult> checkUpgrade(@Header("Authorization") String authorization, @Header("Token") String token, @Body AppInfo appInfo);
//
//    @POST("app/query/forwarderList")
//    Flowable<JsonResult> forwarderList(@Header("Authorization") String authorization, @Header("Token") String token);
//
//
//    @POST("app/query/forwarder/waybill")
//    Flowable<JsonResult> queryWaybillByCity(@Header("Authorization") String authorization,
//                                            @Header("Token") String token, @Body City city);
//
//    @POST("app/returns/query/packinglist")
//    Flowable<JsonResult> getReturnsCartonDetail(@Header("Authorization") String authorization,
//                                                @Header("Token") String token, @Body Carton carton);
//    @POST("/app/getSkuByChannelOrder")
//    Flowable<JsonResult> getSkuByChannelOrder(@Header("Authorization") String authorization,
//                                              @Header("Token") String token, @Body WarePicBean carton);
//    @POST("/app/getWareFileBySku")
//    Flowable<JsonResult> getWareFileBySku(@Header("Authorization") String authorization,
//                                          @Header("Token") String token, @Body WarePicBean carton);
//    @Multipart
//    @POST("/app/upload/wareFile")
//    Flowable<JsonResult> wareFile(@Header("Authorization") String authorization, @Header("Token") String token, @Part("content") WarePicBean warePicBean, @PartMap Map<String, RequestBody> map);

}
