<h2><a href="https://leetcode.com/problems/minimum-string-length-after-removing-substrings/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2696. Minimum String Length After Removing Substrings</a></h2><h3>Easy</h3><hr><div><p>You are given a string <code>s</code> consisting only of <strong>uppercase</strong> English letters.</p>

<p>You can apply some operations to this string where, in one operation, you can remove <strong>any</strong> occurrence of one of the substrings <code>"AB"</code> or <code>"CD"</code> from <code>s</code>.</p>

<p>Return <em>the <strong>minimum</strong> possible length of the resulting string that you can obtain</em>.</p>

<p><strong>Note</strong> that the string concatenates after removing the substring and could produce new <code>"AB"</code> or <code>"CD"</code> substrings.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ABFCACDB"
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can do the following operations:
- Remove the substring "<u>AB</u>FCACDB", so s = "FCACDB".
- Remove the substring "FCA<u>CD</u>B", so s = "FCAB".
- Remove the substring "FC<u>AB</u>", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "ACBBD"
<strong>Output:</strong> 5
<strong>Explanation:</strong> We cannot do any operations on the string so the length remains the same.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code>&nbsp;consists only of uppercase English letters.</li>
</ul>
</div>