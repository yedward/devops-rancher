package devops

/**
 * 通用HTTP请求工具
 *
 * @param apiServerUrl
 * @param apiToken
 * @param httpMode
 * @param requestBody
 * @return
 */
def handleRequest(String apiServerUrl, String apiToken, String httpMode, String requestBody) {
    httpRequest customHeaders: [[maskValue: true, name: 'Authorization', value: "Bearer ${apiToken}"],
                                [maskValue: false, name: 'Content-Type', value: 'application/json'],
                                [maskValue: false, name: 'Accept', value: 'application/json']],
            httpMode: "${httpMode}",
            consoleLogResponseBody: true,
            ignoreSslErrors: true,
            requestBody: "${requestBody}",
            url: "${apiServerUrl}"
}