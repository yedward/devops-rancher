package devops;

/**
 * Rancher Tools
 */
class Rancher {
    /**
     * 发布
     * @return
     */
    def deploy() {
        println("发布成功")
        System.out.println("system 发布成功")
    }

    /**
     * 测试HTTP请求
     */
    def testHttpRequest(param1) {
        def response = httpRequest "http://httpbin.org/response-headers?param1=${param1}"
        println('Status: '+response.status)
        println('Response: '+response.content)
    }
}

