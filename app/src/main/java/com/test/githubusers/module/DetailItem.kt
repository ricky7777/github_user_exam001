package com.test.githubusers.module

import java.io.Serializable


class DetailItem: Serializable {

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
    private var name = ""
    private var company = ""
    private var blog = ""
    private var location = ""
    private var email = ""
    private var hireable = ""
    private var bio = ""
    private var twitter_username = ""
    private var public_repos = 0
    private var public_gists = 0
    private var followers = 0
    private var following = 0
    private var created_at = ""
    private var updated_at = ""


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

    fun get_name(): String {
        return name
    }

    fun set_name(name: String) {
        this.name = name
    }

    fun get_company(): String {
        return company
    }

    fun set_company(company: String) {
        this.company = company
    }

    fun get_blog(): String {
        return blog
    }

    fun set_blog(blog: String) {
        this.blog = blog
    }

    fun get_location(): String {
        return location
    }

    fun set_location(location: String) {
        this.location = location
    }

    fun get_email(): String {
        return email
    }

    fun set_email(email: String) {
        this.email = email
    }

    fun get_hireable(): String {
        return hireable
    }

    fun set_hireable(hireable: String) {
        this.hireable = hireable
    }

    fun get_bio(): String {
        return bio
    }

    fun set_bio(bio: String) {
        this.bio = bio
    }

    fun get_twitter_username(): String {
        return twitter_username
    }

    fun set_twitter_username(twitter_username: String) {
        this.twitter_username = twitter_username
    }

    fun get_public_repos(): Int {
        return public_repos
    }

    fun set_public_repos(public_repos: Int) {
        this.public_repos = public_repos
    }

    fun get_public_gists(): Int {
        return public_gists
    }

    fun set_public_gists(public_gists: Int) {
        this.public_gists = public_gists
    }

    fun get_followers(): Int {
        return followers
    }

    fun set_followers(followers: Int) {
        this.followers = followers
    }

    fun get_following(): Int {
        return following
    }

    fun set_following(following: Int) {
        this.following = following
    }

    fun get_created_at(): String {
        return created_at
    }

    fun set_created_at(created_at: String) {
        this.created_at = created_at
    }

    fun get_updated_at(): String {
        return updated_at
    }

    fun set_updated_at(updated_at: String) {
        this.updated_at = updated_at
    }

}
