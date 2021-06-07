package com.test.githubusers.module

import java.io.Serializable


class UserItem: Serializable {

    private var login = ""
    private var id: Int = 0
    private var node_id = ""
    private var avatar_url = ""
    private var gravatar_id = ""
    private var url = ""
    private var html_url = ""
    private var followers_url = ""
    private var following_url = ""
    private var gists_url = ""
    private var starred_url = ""
    private var subscriptions_url = ""
    private var organizations_url = ""
    private var repos_url = ""
    private var events_url = ""
    private var received_events_url = ""
    private var type = ""
    private var site_admin = false


    fun get_login(): String {
        return login
    }

    fun set_login(login: String) {
        this.login = login
    }

    fun get_id(): Int? {
        return id
    }

    fun se_id(id: Int) {
        this.id = id
    }

    fun get_node_id(): String {
        return node_id
    }

    fun set_node_id(node_id: String) {
        this.node_id = node_id
    }

    fun get_avatar_url(): String {
        return avatar_url
    }

    fun set_avatar_url(avatar_url: String) {
        this.avatar_url = avatar_url
    }

    fun get_gravatar_id(): String {
        return gravatar_id
    }

    fun set_gravatar_id(gravatar_id: String) {
        this.gravatar_id = gravatar_id
    }

    fun get_url(): String {
        return url
    }

    fun set_url(url: String) {
        this.url = url
    }

    fun get_html_url(): String {
        return html_url
    }

    fun set_html_url(html_url: String) {
        this.html_url = html_url
    }

    fun get_followers_url(): String {
        return followers_url
    }

    fun set_followers_url(followers_url: String) {
        this.followers_url = followers_url
    }

    fun get_following_url(): String {
        return following_url
    }

    fun set_following_url(following_url: String) {
        this.following_url = following_url
    }

    fun get_gists_url(): String {
        return gists_url
    }

    fun set_gists_url(gists_url: String) {
        this.gists_url = gists_url
    }

    fun get_starred_url(): String {
        return starred_url
    }

    fun set_starred_url(starred_url: String) {
        this.starred_url = starred_url
    }

    fun get_subscriptions_url(): String {
        return subscriptions_url
    }

    fun set_subscriptions_url(subscriptions_url: String) {
        this.subscriptions_url = subscriptions_url
    }

    fun get_organizations_url(): String {
        return organizations_url
    }

    fun set_organizations_url(organizations_url: String) {
        this.organizations_url = organizations_url
    }

    fun get_repos_url(): String {
        return repos_url
    }

    fun set_repos_url(repos_url: String) {
        this.repos_url = repos_url
    }

    fun get_events_url(): String {
        return events_url
    }

    fun set_events_url(events_url: String) {
        this.events_url = events_url
    }

    fun get_received_events_url(): String {
        return received_events_url
    }

    fun set_received_events_url(received_events_url: String) {
        this.received_events_url = received_events_url
    }

    fun get_type(): String {
        return type
    }

    fun set_type(type: String) {
        this.type = type
    }

    fun get_site_admin(): Boolean {
        return site_admin
    }

    fun set_site_admin(site_admin: Boolean) {
        this.site_admin = site_admin
    }



}
