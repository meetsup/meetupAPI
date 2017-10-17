package top.shellteo.service;

/**
 * Created by HP on 2017/10/16.
 */
public interface HomePageService {
    /**
     * 活动列表/搜索
     * @param jsonData
     * @return
     */
    String getAllActivityLimit(String jsonData, String type);

    /**
     * 活动详情
     * @param jsonData
     * @return
     */
    String getDetail(String jsonData);
}
