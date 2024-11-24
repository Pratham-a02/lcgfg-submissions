<h2><a href="https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>3365. Rearrange K Substrings to Form Target String</a></h2><h3>Medium</h3><hr><div><p>You are given two strings <code>s</code> and <code>t</code>, both of which are anagrams of each other, and an integer <code>k</code>.</p>

<p>Your task is to determine whether it is possible to split the string <code>s</code> into <code>k</code> equal-sized substrings, rearrange the substrings, and concatenate them in <em>any order</em> to create a new string that matches the given string <code>t</code>.</p>

<p>Return <code>true</code> if this is possible, otherwise, return <code>false</code>.</p>

<p>An <strong>anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.</p>

<p>A <strong>substring</strong> is a contiguous <b>non-empty</b> sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcd", t = "cdab", k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Split <code>s</code> into 2 substrings of length 2: <code>["ab", "cd"]</code>.</li>
	<li>Rearranging these substrings as <code>["cd", "ab"]</code>, and then concatenating them results in <code>"cdab"</code>, which matches <code>t</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aabbcc", t = "bbaacc", k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Split <code>s</code> into 3 substrings of length 2: <code>["aa", "bb", "cc"]</code>.</li>
	<li>Rearranging these substrings as <code>["bb", "aa", "cc"]</code>, and then concatenating them results in <code>"bbaacc"</code>, which matches <code>t</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aabbcc", t = "bbaacc", k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Split <code>s</code> into 2 substrings of length 3: <code>["aab", "bcc"]</code>.</li>
	<li>These substrings cannot be rearranged to form <code>t = "bbaacc"</code>, so the output is <code>false</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length == t.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
	<li><code>s.length</code> is divisible by <code>k</code>.</li>
	<li><code>s</code> and <code>t</code> consist only of lowercase English letters.</li>
	<li>The input is generated such that<!-- notionvc: 53e485fc-71ce-4032-aed1-f712dd3822ba --> <code>s</code> and <code>t</code> are anagrams of each other.</li>
</ul>
</div>