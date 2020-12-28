package devops

def api_token = "SKFJLSDJFKDSJFLKDSFJLDKSFJLDSFKDSLFJ"

/**
 * HTTP GET请求
 */
static def httpGet() {
    println("httpGet ${api_token}")
}

/**
 * HTTP POST请求
 */
static def httpPost() {
    println("httpPost")
}
