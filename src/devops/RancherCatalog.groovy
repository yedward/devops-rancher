package devops

/**
 * 添加一个应用商店
 *
 * 示例：
 *  添加商店：
 *  url: https://rancher_api_url/v3/projectcatalog
 *  method:POST
 *  request payload：
 *  {
 *  "type": "projectcatalog",
 *  "kind": "helm",
 *  "branch": "your_branch",
 *  "projectId": "your_cluster_project_id",
 *  "helmVersion": "helm_v3",
 *  "name": "your_catalog_name",
 *  "url": "https://github.com/xxxx/xxxx.git",
 *  "username": "your_username",
 *  "password": "your_password"
 *  }
 */
def add(String clusterProjectId, String name, String url, String branch, String username, String password) {
    println("---------------【添加Git仓库地址到应用商店】开始--------------")
    Application application = new Application()
    String requestBody = """
     {
     "type": "projectcatalog",
     "kind": "helm",
     "branch": "${branch}",
     "projectId": "${clusterProjectId}",
     "helmVersion": "helm_v3",
     "name": "${name}",
     "url": "${url}",
     "username": "${username}",
     "password": "${password}"
     }
"""
    def response = application.handleRequest("POST","/projectcatalog", "${requestBody}")
    println("---------------【添加Git仓库地址到应用商店】结束--------------")
    return response
}

/**
 * 刷新指定应用商店
 *
 * 示例：
 *  刷新指定应用商店
 *  url: https://rancher_api_url/v3/projectCatalogs/your_project_id:your_catalog_name?action=refresh
 *  method:POST
 *
 */
def refresh(String projectId, String name) {
    println("---------------【刷新应用商店】开始--------------")
    Application application = new Application()
    def response =  application.handleRequest("POST","/projectCatalogs/${projectId}:${name}?action=refresh", null)
    println("---------------【刷新应用商店】结束--------------")
    return response
}